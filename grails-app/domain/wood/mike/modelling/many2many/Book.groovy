package wood.mike.modelling.many2many

class Book {
    static belongsTo = Author
    static hasMany = [authors:Author]
    String title
}
