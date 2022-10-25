package wood.mike.eagerLazy

class Flight {
    String number
    Location destination
    static belongsTo = [airport: Airport]
}
