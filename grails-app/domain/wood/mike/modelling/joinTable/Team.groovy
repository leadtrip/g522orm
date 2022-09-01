package wood.mike.modelling.joinTable

class Team {

    String name
    static hasMany = [cyclist: Cyclist]

    static mapping = {
        cyclist column: 'team_id', joinTable: 'CYCLIST_TEAM_TBL'
    }
}
