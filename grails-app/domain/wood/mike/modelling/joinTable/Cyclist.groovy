package wood.mike.modelling.joinTable

class Cyclist {

    String name
    static belongsTo = Team
    static hasMany = [teams: Team]

    static mapping = {
        teams column: 'cyclist_id', joinTable: 'CYCLIST_TEAM_TBL'
    }
}
