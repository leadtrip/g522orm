package wood.mike

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.grails.orm.hibernate.cfg.GrailsHibernateUtil
import spock.lang.Specification
import wood.mike.proxies.Fish
import wood.mike.proxies.Owner

@Integration
@Rollback
/**
 * Hibernate uses runtime-generated proxies to facilitate single-ended lazy associations;
 * Hibernate dynamically subclasses the entity class to create the proxy.
 *
 * Because the proxy is only a subclass of the parent class, any attempt to cast or access data on the subclass will fail.
 */
class ProxyIntegrationSpec extends Specification{

    def proxyHandler

    def setup() {
        new Owner(name: 'Bill', pet: new Fish(name: 'Elmo', preferredWaterTemp: 22)).save()
    }

    void "test proxy using standard instanceof"() {
        when:
            def owner = Owner.findByName('Bill')
        then:
            !(owner.pet instanceof Fish)            // it's a Hibernate proxy
    }

    void "test proxy using GormEntity instanceOf"() {
        when:
            def owner = Owner.findByName('Bill')
        then:
           owner.pet.instanceOf Fish            // causes a call to the database but gets the real class
    }

    void "test proxy using standard instanceof with join"() {
        when:
            def owner = Owner.where{ name == 'Bill' }.join('pet').get()     // eagerly fetch the pet
        then:
            owner.pet instanceof Fish           // now standard instanceof works
    }

    /**
     * If DI is available use the proxyHandler
     */
    void "test proxyHandler"() {
        when:
            def owner = Owner.findByName('Bill')
        then:
            proxyHandler.isProxy(owner.pet)
        and:
           proxyHandler.unwrapIfProxy(owner.pet) instanceof Fish
    }

    /**
     * If DI isn't available, use static call to GrailsHibernateUtil
     */
    void "test GrailsHibernateUtil"() {
        when:
            def owner = Owner.findByName('Bill')
        then:
            GrailsHibernateUtil.unwrapIfProxy(owner.pet) instanceof Fish
    }

    void "test proxy method access"() {
        when:
            def owner = Owner.findByName('Bill')
            def pet = owner.pet
        then:
            !(pet instanceof Fish)
        and:
            pet.preferredWaterTemp == 22      // without doing anything special, we can access fields only on the subclass even though it's still a proxy, is this weird?
        and:
            !(pet instanceof Fish)          // still a proxy after property access?
    }
}
