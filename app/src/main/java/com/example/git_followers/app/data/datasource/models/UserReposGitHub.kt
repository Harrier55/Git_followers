package com.example.git_followers.app.data.datasource.models

import com.google.gson.annotations.SerializedName



data class UserReposGitHub (

	@SerializedName("id"                          ) var id                       : Int?              = null,
	@SerializedName("node_id"                     ) var nodeId                   : String?           = null,
	@SerializedName("name"                        ) var name                     : String?           = null,
	@SerializedName("full_name"                   ) var fullName                 : String?           = null,
	@SerializedName("private"                     ) var private                  : Boolean?          = null,
	@SerializedName("owner"                       ) var owner                    : Owner?            = Owner(),
	@SerializedName("html_url"                    ) var htmlUrl                  : String?           = null,
	@SerializedName("description"                 ) var description              : String?           = null,
	@SerializedName("created_at"                  ) var createdAt                : String?           = null,
	@SerializedName("updated_at"                  ) var updatedAt                : String?           = null,
	@SerializedName("pushed_at"                   ) var pushedAt                 : String?           = null,
	@SerializedName("size"                        ) var size                     : Int?              = null,
	@SerializedName("stargazers_count"            ) var stargazersCount          : Int?              = null,
	@SerializedName("watchers_count"              ) var watchersCount            : Int?              = null,
	@SerializedName("language"                    ) var language                 : String?           = null,
	@SerializedName("forks_count"                 ) var forksCount               : Int?              = null,
	@SerializedName("forks"                       ) var forks                    : Int?              = null,
	@SerializedName("open_issues"                 ) var openIssues               : Int?              = null,
	@SerializedName("watchers"                    ) var watchers                 : Int?              = null,
	@SerializedName("default_branch"              ) var defaultBranch            : String?           = null


)