# Dice
[![](https://i.loli.net/2019/02/25/5c72cb43993d8.png)](http://www.mcbbs.net/thread-847592-1-1.html "骰子")
Dice plugin for Nukkit

Please see [mcbbs](http://www.mcbbs.net/thread-847592-1-1.html) for more information.

| Command | Permission | Description |
| - | - | - |
| `/dice` or `/roll` | `dice.command` (default) | Allows player to roll dice |
## config.yml
```yaml
#Random number range from 1 to this value. This value must be greater than 1.
max: 6
#Broadcast message
msg: "&9[Dice] &8&o%PLAYER% rolled %RESULT%"
```
### Available variables for message
`%PLAYER%` Command sender's name

`%RESULT%` Customized random number
