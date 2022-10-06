CREATE TABLE `task`
(
    `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `input`           VARCHAR(255) NOT NULL,
    `pattern`         VARCHAR(255) NOT NULL,
    `status`          VARCHAR(255) NOT NULL,
    `progress`        INT UNSIGNED NOT NULL,
    `result_position` INT UNSIGNED NULL,
    `result_typos`    INT UNSIGNED NULL,

    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;
