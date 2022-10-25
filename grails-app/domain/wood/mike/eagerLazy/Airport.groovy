package wood.mike.eagerLazy

/**
 * runways has no additional mapping config & uses the default lazy loading strategy
 * flights uses eager loading, after the Airport has been loaded a 2nd query is executed to fetch the flights
 * terminals again uses eager loading but this time the Airport and Terminals will be fetched in a single query
 */
class Airport {
    String name
    static hasMany = [runways: Runway, flights: Flight, terminals: Terminal]
    static mapping = {
        flights lazy: false
        terminals fetch: 'join'
    }
}
