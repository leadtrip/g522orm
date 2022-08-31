package wood.mike.modelling.many2many

class Author {
    static hasMany = [books:Book]
    String name
}
