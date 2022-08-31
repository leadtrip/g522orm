package wood.mike.modelling.one2many

class Ram {
    Integer capacity
    Integer speed
    MotherBoard motherBoard             // doing this and line below is functionally equivalent (schema generation wise) of static belongsTo = [motherBoard: MotherBoard]
    static belongsTo = MotherBoard      // don't know why you'd prefer this option
}
