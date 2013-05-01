package databinding

class Business {
    String name
    static hasMany = [addresses: Address]
    List addresses
}
