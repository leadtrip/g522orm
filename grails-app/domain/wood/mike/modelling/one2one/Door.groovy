package wood.mike.modelling.one2one

/**
 * Door references Handle and vice-versa making this a bidirectional relationship
 * Door also references Letterbox through the static hasOne reference making this a true 121
 * The schema looks like below, note how the foreign key is inverted when using hasOne (LetterBox) as opposed to not (Handle)
 * ------        -------     ----------
 * door          handle      letter_box
 * ------        -------     ----------
 * id            id          id
 * handle_id     colour      colour
 * width         -------     door_id
 * height                    -----------
 * --------
 */
class Door {
    Integer width
    Integer height
    Handle handle
    static hasOne = [letterBox: LetterBox]
}
