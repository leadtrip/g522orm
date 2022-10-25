package g522orm

class AirportController {

    def airportService

    def index() {
        airportService.loadAirports()
    }

    def getAirport() {
        airportService.getAirport()
    }

    def getAirportEager() {
        airportService.getAirportEager()
    }
}
