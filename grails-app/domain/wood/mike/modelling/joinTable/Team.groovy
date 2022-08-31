package wood.mike.modelling.joinTable

class Team {

    String name
    static hasMany = [cyclist: Cyclist]
    static mapping = {
        cyclist column: 'cyclist_team_id', joinTable: 'CYCLIST_TEAM_TBL'
    }
}
