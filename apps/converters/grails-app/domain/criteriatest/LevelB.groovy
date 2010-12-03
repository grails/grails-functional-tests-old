package criteriatest

class LevelB {

  int lvlB
  LevelA levelA
  String name
  int baseLevel
  int maxLevel
  float baseAttack
  float attackIncrement
  float baseDefense
  float defenseIncrement
  int baseHitPoints
  int hitPointsIncrement
  float baseHitRatio
  float hitRatioIncrement
  long baseCost
  long costIncrement
  List levelsC
  TestEnumTwo testEnumTwo

  static hasMany = [levelsC: LevelC]

  static mapping = {
    cache true
  }
}
