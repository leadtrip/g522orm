package wood.mike.modelling.one2many

/**
 * Schema looks like following, only relevant fields shown.
 *
 * mother_board     mother_board_gpus       gpu   ram                 hard_drive
 * ------------     -----------------       ---   ---                 ----------
 * id               mother_board_gpus_id    id    id                  id
 *                  gpu_id                        mother_board_id     mother_board_id
 *
 * Gpu doesn't specify back reference to MotherBoard so join table is created named mother_board_gpus.
 * Both Ram and HardDrive specify belongsTo so FK is included in their respective tables
 */
class MotherBoard {
    String model
    static hasMany = [gpus: Gpu, hardDrives: HardDrive, memory: Ram]
}
