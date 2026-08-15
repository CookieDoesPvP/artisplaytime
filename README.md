# ArtisPlaytime

ArtisPlaytime is a commissioned Minecraft Bukkit/Spigot plugin developed in 2018 for the Artis server.

The plugin provides players with a formatted breakdown of their total server playtime using Minecraft's built-in player statistics, alongside PlaceholderAPI integration for displaying playtime elsewhere across the server.

## Project history

This plugin was originally developed as a commissioned piece in 2018, before I routinely used Git/GitHub for version control.

This repository was created retrospectively from the surviving source code, so the Git history does not represent the project's original development timeline.

## Features

* **Player playtime tracking**
  Uses Minecraft's built-in `PLAY_ONE_TICK` player statistic to determine total time played.

* **Formatted playtime display**
  Converts raw playtime into days, hours, minutes and seconds for player-friendly output.

* **Configurable messages**
  The playtime message is read from the plugin configuration and supports placeholders for:

  * `{DAYS}`
  * `{HOURS}`
  * `{MINUTES}`
  * `{SECONDS}`

* **Minecraft colour code support**
  Configured messages support standard Bukkit `&` colour codes.

* **Player lookup**
  The `/playtime <player>` command can retrieve playtime statistics for another player who is currently online.

* **PlaceholderAPI integration**
  Registers an Artis-specific PlaceholderAPI expansion exposing player playtime in hours for use by compatible plugins.

## Commands

### `/playtime`

Displays the player's total playtime as a formatted combination of days, hours, minutes and seconds.

### `/playtime <player>`

Retrieves the playtime of another online player.

The surviving source also contains an early implementation of a `/playtime top` command intended to rank online players by playtime. This functionality appears to have been unfinished in the archived version and is therefore not listed as a completed feature.

## PlaceholderAPI

When PlaceholderAPI is installed, the plugin registers the `artisplaytime` expansion.

The expansion calculates player playtime from the Minecraft `PLAY_ONE_TICK` statistic and exposes the resulting total in hours.

## Technologies

* Java
* Bukkit / Spigot API
* Minecraft player statistics
* PlaceholderAPI
* YAML configuration

## Compatibility

> **Note:** This project was developed against Bukkit/Spigot and PlaceholderAPI versions in use around 2018. It is retained as a historical portfolio project and may require modification to run with current Minecraft server versions and APIs.
