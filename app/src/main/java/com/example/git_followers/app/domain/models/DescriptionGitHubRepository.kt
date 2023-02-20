package com.example.git_followers.app.domain.models

internal data class DescriptionGitHubRepository(
    val id: Int?                 = null,
    val userName: String?        = null,
    val name: String?            = null,
    val avatar_url: String?      = null,
    val description: String?     = null,
    val updated_at: String?      = null,
    val default_branch: String?  = null,
    val forks_count: Int?        = null,
    val stargazers_count: Int?   = null,

    )
