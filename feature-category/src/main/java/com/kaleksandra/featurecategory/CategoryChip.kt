package com.kaleksandra.featurecategory

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaleksandra.coretheme.Dimen
import com.kaleksandra.coretheme.VKCupQualification2022Theme

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun CategoryChip(category: Category, index: Int, onCheck: (Int, Boolean) -> Unit) {
    val tintColor = if (!category.checked) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }
    FilterChip(
        selected = category.checked,
        onClick = { onCheck(index, !category.checked) },
        label = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Min),
            ) {
                Text(
                    text = category.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = tintColor,
                )
                Divider(
                    color = tintColor,
                    modifier = Modifier
                        .padding(start = Dimen.padding_16)
                        .fillMaxHeight()
                        .width(Dimen.width_1),
                )
                AnimatedContent(
                    targetState = category.checked,
                    transitionSpec = {
                        scaleIn() + fadeIn() with scaleOut() + fadeOut()
                    },
                ) {
                    Icon(
                        imageVector = if (!category.checked) {
                            Icons.Outlined.Add
                        } else {
                            Icons.Outlined.Check
                        },
                        contentDescription = if (!category.checked) {
                            stringResource(R.string.icon_description_add)
                        } else {
                            stringResource(R.string.icon_description_check)
                        },
                        modifier = Modifier.padding(start = Dimen.padding_12),
                        tint = tintColor,
                    )
                }
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surface,
            selectedContainerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(Dimen.radius_8),
        border = FilterChipDefaults.filterChipBorder(Color.Transparent),
        modifier = Modifier.requiredHeight(Dimen.height_40),
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
private fun Preview() {
    VKCupQualification2022Theme {
        Column(verticalArrangement = Arrangement.spacedBy(Dimen.padding_8)) {
            CategoryChip(Category(1, "Юмор", false), 1) { _, _ -> }
            CategoryChip(Category(1, "Юмор", true), 1) { _, _ -> }
        }
    }
}