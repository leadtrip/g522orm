package wood.mike.modelling.one2one

/**
 * LetterBox belongsTo Door, the class specified by belongsTo assumes ownership of the relationship
 */
class LetterBox {

    String colour
    static belongsTo = [door: Door]
}
