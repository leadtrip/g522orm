package wood.mike.modelling.one2many

class HardDrive {
    Integer capacityGb
    static belongsTo = [motherBoard: MotherBoard]
}
