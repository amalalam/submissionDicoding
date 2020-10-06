package com.light.alam_githubappuser

object UserData {
    private val userNames = arrayOf(
        "Amal Nur Alam",
        "Zulfan Fasya",
        "Nurirvan Mulia",
        "Putra Ahmad",
        "Syahla Zuelvia",
        "Hani Febriyani",
        "Ghina Amalia",
        "Amalia Nur",
        "Aprlia",
        "Ratu Putri")

    private val username = arrayOf(
        "amalam8",
        "zulfanFasya",
        "nurirvanmulia",
        "putraAhmad7",
        "zuelvia06",
        "haniFebri",
        "gwinaAmel",
        "amaliaNur2",
        "apriliaKhaerunisa",
        "putriRatu"
        )
    private val userImages = arrayOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5,
        R.drawable.user6,
        R.drawable.user7,
        R.drawable.user8,
        R.drawable.user9,
        R.drawable.user10)

    private val company = arrayOf(
        "Google, Inc.",
        "MindOrksOpenSource",
        "Google",
        "Google working on @android",
        "Working Group Two",
        "AndroidHive | Droid5",
        "gojek-engineering",
        "KotlinID",
        "JVMDeveloperID @KotlinID @IDDevOps",
        "Nusantara Beta Studio"
    )

    private val location = arrayOf(
        "Pittsburgh, PA, USA",
        "New Delhi, India",
        "California",
        "Sydney, Australia",
        "Trondheim, Norway",
        "India",
        "Kotagede, Yogyakarta, Indonesia",
        "Jakarta, Indonesia",
        "Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"
    )

    private val repository = intArrayOf(
        123,
        34,
        90,
        31,
        58,
        25,
        444,
        13,
        164,
        64
    )

    private val follower = intArrayOf(
        5995,
        5153,
        772,
        1725,
        788,
        1628,
        277,
        18,
        48,
        465
    )

    private val following = intArrayOf(
        12,
        24,
        10,
        13,
        5,
        30,
        39,
        23,
        61,
        10
    )

    val listData: ArrayList<User>
        get() {
            val list = arrayListOf<User>()
            for (position in userNames.indices) {
                val user = User()
                user.name = userNames[position]
                user.username = username[position]
                user.photo = userImages[position]
                user.company = company[position]
                user.location = location[position]
                user.repository = repository[position]
                user.follower = follower[position]
                user.following = following[position]
                list.add(user)
            }
            return list
        }
}

