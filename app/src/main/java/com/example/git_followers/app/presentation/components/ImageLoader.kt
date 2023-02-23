package com.example.git_followers.app.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
 fun ImageLoader(imageUrl: String) {
    GlideImage(
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    ) {
        it.diskCacheStrategy(DiskCacheStrategy.ALL).circleCrop()
    }
}