package wood.mike.modelling.one2one

/**
 * Handle references Door and vice-versa making this a bidirectional relationship between the 2
 */
class Handle {
    String colour
    static belongsTo = [door: Door]
}
