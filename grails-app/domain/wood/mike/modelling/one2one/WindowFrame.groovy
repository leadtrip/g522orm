package wood.mike.modelling.one2one

/**
 * WindowFrame references WindowPane but not the other way round making this a unidirectional relationship
 */
class WindowFrame {
    Integer width
    Integer height
    WindowPane windowPane
}
