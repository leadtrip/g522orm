package wood.mike

import grails.gorm.transactions.Transactional
import wood.mike.eagerLazy.Airport
import wood.mike.eagerLazy.Flight
import wood.mike.eagerLazy.Location
import wood.mike.eagerLazy.Runway
import wood.mike.eagerLazy.Terminal

@Transactional
class AirportService {

    def loadAirports() {
        if( !Airport.findByName('Heathrow') ) {
            def airport = new Airport(name: 'Heathrow')
            airport.addToTerminals(new Terminal(name: 'T1'))
            airport.addToTerminals(new Terminal(name: 'T2'))
            airport.addToFlights(new Flight(number: 123, destination: new Location(country: 'USA', city: 'LA')))
            airport.addToFlights(new Flight(number: 321, destination: new Location(country: 'USA', city: 'NY')))
            airport.addToRunways(new Runway(name: 'R1'))
            airport.addToRunways(new Runway(name: 'R2'))
            airport.save()
        }
    }

    def getAirport() {
        Airport.findByName('Heathrow')
    }

    def getAirportEager() {
        Airport.findByName( 'Heathrow', [fetch: [runways: 'join']])
    }
}
