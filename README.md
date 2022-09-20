The following diagrams depict the schema created by grails for the various domain relationships

View the schema at http://localhost:3719/h2-console

one 2 one
------------------------------------------
| door      | handle | letter_box |
|-----------|--------|------------|
| id        | id     | id         |
| handle_id |        | door_id    |

one 2 many
----------------------------
| mother_board |mother_board_gpus   |gpu|ram            | hard_drive      |
|--------------|-----------------   |---|---            |-----------------|
| id           |mother_board_gpus_id|id |id             | id              |
|              |gpu_id              |   |mother_board_id| mother_board_id |

many 2 many
----------------------------
| author | book  | author_books |
|--------|-------|--------------|
| id     | id    | author_id    |
| name   | title | book_id      |

join table
----------------------------
|cyclist|team   |cyclist_team_tbl|
|-------|-------|----------------|
|id     |id     |cyclist_team_id |
|name   |name   |team_team_id    |
