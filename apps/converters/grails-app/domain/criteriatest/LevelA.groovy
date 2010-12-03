package criteriatest

class LevelA {

    int lvlA
      TestEnum testEnum
    TestEnumTwo test2Enum

    static hasMany = [levelsB: LevelB]
    static constraints = {
    }

  static mapping = {
      cache true
    }

  def justATest = {
    return 1
  }

  int test2() {
    return 2
  }
}
