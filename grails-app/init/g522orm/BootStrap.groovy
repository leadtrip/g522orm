package g522orm

import grails.gorm.transactions.Transactional
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

    def destroy = {
    }
}
