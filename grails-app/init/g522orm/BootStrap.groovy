package g522orm

import grails.gorm.transactions.Transactional
import wood.mike.modelling.basicCollectionTypes.Person
import wood.mike.modelling.composition.Motorist
import wood.mike.modelling.composition.Vehicle
import wood.mike.modelling.joinTable.Cyclist
import wood.mike.modelling.joinTable.Team
import wood.mike.modelling.many2many.Author
import wood.mike.modelling.many2many.Book
import wood.mike.modelling.one2many.Gpu
import wood.mike.modelling.one2many.HardDrive
import wood.mike.modelling.one2many.MotherBoard
import wood.mike.modelling.one2many.Ram

class BootStrap {

    def init = { servletContext ->
        addData()
    }

    @Transactional
    def addData() {
        addMotherboard()
        addBooks()
        addCyclists()
        addPersons()
        addMotorists()
    }

    def addCyclists() {
        def bob = new Cyclist(name: 'Bob')

        new Team(name: 'Going nowhere')
            .addToCyclist(bob)
            .addToCyclist(new Cyclist(name: 'Karen'))
            .save()

        new Team(name: 'Wheelie good')
            .addToCyclist(bob)
            .addToCyclist(new Cyclist(name: 'Les'))
            .save()
    }

    def addBooks() {
        new Author(name: 'Marlon Pilchard')
            .addToBooks(new Book(title: 'Rampant'))
            .addToBooks(new Book(title: 'Kennel'))
            .save()
    }

    def addMotherboard() {
        def ram1 = new Ram(capacity: 512, speed: 4000)
        def ram2 = new Ram(capacity: 512, speed: 4000)
        def gpu1 = new Gpu(memory: 1024, speed: 5000)
        def gpu2 = new Gpu(memory: 2048, speed: 6000)
        def hdd1 = new HardDrive(capacityGb: 1000)
        def hdd2 = new HardDrive(capacityGb: 4000)
        def mobo = new MotherBoard(model: 'ZZ99')
        mobo.addToMemory(ram1)
        mobo.addToMemory(ram2)
        mobo.addToGpus(gpu1)
        mobo.addToGpus(gpu2)
        mobo.addToHardDrives(hdd1)
        mobo.addToHardDrives(hdd2)
        mobo.save()
    }

    def addPersons() {
        def person1 = new Person(name: 'Arnold')
        person1.nicknames = ['Arn', 'Arnie']
        person1.friends = ['Jon', 'Kev']
        person1.allergies = ['Hayfever', 'Work']
        person1.features = [height: '180', footSize: '10']
        person1.save()
    }

    def addMotorists() {
        def motorist1 = new Motorist(name: 'Barry')
        motorist1.dailyRunner = new Vehicle(type: 'Car', mfr: 'Renault', model: '5')
        motorist1.weekendSpecial = new Vehicle(type: 'Bike', mfr: 'Specialized', model: 'Tarmac')
        motorist1.save()
    }

    def destroy = {
    }
}
