package com.example.authmobileappintern2grow.network.request

object DummyRegister {
    val hair = Hair(color = "Black", type = "Strands")
    val coordinates = Coordinates(lat = 38.867033, lng = -76.979235)
    val address = Address(
        address = "1745 T Street Southeast",
        city = "Washington",
        coordinates = coordinates,
        postalCode = "20020",
        state = "DC"
    )
    val bank = Bank(
        cardExpire = "06/22",
        cardNumber = "50380955204220685",
        cardType = "maestro",
        currency = "Peso",
        iban = "NO17 0695 2754 967"
    )
    val companyAddress = Address(
        address = "629 Debbie Drive",
        city = "Nashville",
        coordinates = Coordinates(lat = 36.208114, lng = -86.586212),
        postalCode = "37076",
        state = "TN"
    )
    val company = Company(
        address = companyAddress,
        department = "Marketing",
        name = "Blanda-O'Keefe",
        title = "Help Desk Operator"
    )

    val registerUserRequest = RegisterUserRequest(
        id = 1,
        firstName = "Terry",
        lastName = "Medhurst",
        maidenName = "Smitham",
        age = 50,
        gender = "male",
        email = "atuny0@sohu.com",
        phone = "+63 791 675 8914",
        username = "atuny0",
        password = "9uQFF1Lh",
        birthDate = "2000-12-25",
        image = "https://robohash.org/hicveldicta.png?size=50x50&set=set1",
        bloodGroup = "A−",
        height = 189.0,
        weight = 75.4,
        eyeColor = "Green",
        hair = hair,
        domain = "slashdot.org",
        ip = "117.29.86.254",
        address = address,
        macAddress = "13:69:BA:56:A3:74",
        university = "Capitol University",
        bank = bank,
        company = company,
        ein = "20-9487066",
        ssn = "661-64-2976",
        userAgent = "Mozilla/5.0"
    )

}