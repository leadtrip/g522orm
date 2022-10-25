package wood.mike.modelling.composition

/**
 * GORM supports the notion of composition.
 * In this case instead of mapping classes onto separate tables a class can be "embedded" within the current table like:
 *
 * motorist
 * |id|daily_runner_mfr|daily_runner_type|daily_runner_model|weekend_special_mfr|weekend_special_model| weekend_special_model |
 */
class Motorist {
    String name
    Vehicle dailyRunner
    Vehicle weekendSpecial
    static embedded = ['dailyRunner', 'weekendSpecial']
}

class Vehicle {
    String type
    String mfr
    String model
}