package wood.mike.modelling.joinTable

class Cyclist {

    String name
    static belongsTo = Team
    static hasMany = [teams: Team]

    static mapping = {
        teams column: 'team_team_id', joinTable: 'CYCLIST_TEAM_TBL'
    }
}
