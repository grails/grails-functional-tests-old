package databinding

class NumberChild {

    static hasMany = [someOtherIds: Integer]

    String toString() {
        "NumberChild Ids: ${someOtherIds}"
    }
}
