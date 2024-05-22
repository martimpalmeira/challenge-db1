package br.com.challengedb1.model

data class UserProfile(
    val id: String,
    val name: String,
    val role: Role,
    val experience: String,
    val skills: List<String>,
    val interests: List<String>,
    val education: String
)

enum class Role {
    MENTOR, APPRENTICE
}

data class Match(
    val mentor: UserProfile,
    val apprentice: UserProfile,
    val commonInterests: List<String>
)
