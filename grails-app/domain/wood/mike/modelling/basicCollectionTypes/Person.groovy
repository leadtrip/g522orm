package wood.mike.modelling.basicCollectionTypes

class Person {

    String name
    List friends
    Collection allergies
    Map features
    static hasMany = [nicknames: String, friends: String, allergies: String]

    static constraints = {
    }
}
