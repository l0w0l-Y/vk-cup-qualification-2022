@file:OptIn(ExperimentalMaterial3Api::class)

package com.kaleksandra.featurecategory

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.flowlayout.FlowRow
import com.kaleksandra.coretheme.Dimen
import com.kaleksandra.coretheme.VKCupQualification2022Theme

@Composable
fun CategoryScreen(categoryViewModel: CategoryViewModel = viewModel()) {
    val uiState by categoryViewModel.uiState.collectAsState()
    CategoryScreen(
        categories = uiState.categories,
        onCheck = categoryViewModel::onCheckCategory,
        onContinueClick = categoryViewModel::onContinueClick,
        onNavigateNextScreen = {/*TODO: Add navigation*/ },
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun CategoryScreen(
    categories: List<Category>,
    onCheck: (Int, Boolean) -> Unit,
    onContinueClick: () -> Unit,
    onNavigateNextScreen: () -> Unit,
) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = Dimen.padding_16),
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = Dimen.padding_16)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(id = R.string.title_category_dzen_interest),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(Dimen.weight_1),
                )
                Button(
                    onClick = onNavigateNextScreen,
                    contentPadding = PaddingValues(
                        horizontal = Dimen.padding_12,
                        vertical = Dimen.padding_8,
                    ),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier
                        .padding(start = Dimen.padding_12)
                        .defaultMinSize(
                            minWidth = Dimen.width_1,
                            minHeight = Dimen.height_1,
                        ),
                ) {
                    Text(
                        text = stringResource(id = R.string.button_category_choose_later),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }

            FlowRow(
                mainAxisSpacing = Dimen.axis_4,
                crossAxisSpacing = Dimen.axis_4,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(Dimen.weight_1)
                    .fillMaxWidth()
                    .padding(horizontal = Dimen.padding_16)
                    .padding(
                        top = Dimen.padding_24,
                        bottom = Dimen.padding_20,
                    ),
            ) {
                for (index in categories.indices) {
                    CategoryChip(
                        category = categories[index], index = index, onCheck = onCheck,
                    )
                }
            }

            AnimatedVisibility(categories.any { it.checked }) {
                Button(
                    onClick = onContinueClick,
                    contentPadding = PaddingValues(
                        vertical = Dimen.padding_28,
                        horizontal = Dimen.padding_48,
                    ),
                    modifier = Modifier.padding(
                        top = Dimen.padding_20,
                        bottom = Dimen.padding_16,
                    ),
                ) {
                    Text(
                        text = stringResource(id = R.string.button_category_continue),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun Preview() {
    VKCupQualification2022Theme {
        CategoryScreen(categories = listOf(
            Category(1, "Юмор", false),
            Category(2, "Еда", false),
            Category(3, "Кино", false),
            Category(4, "Рестораны", false),
            Category(5, "Прогулки", false),
            Category(6, "Политика", false),
            Category(7, "Новости", false),
            Category(8, "Автомобили", false),
            Category(9, "Сериалы", false),
            Category(10, "Рецепты", false),
            Category(11, "Работа", false),
            Category(12, "Отдых", false),
            Category(13, "Спорт", false),
            Category(14, "Юмор", false),
            Category(15, "Еда", false),
            Category(16, "Кино", false),
            Category(17, "Рестораны", false),
            Category(18, "Прогулки", false),
            Category(19, "Политика", false),
            Category(20, "Новости", false),
            Category(21, "Автомобили", false),
            Category(22, "Сериалы", false),
            Category(23, "Рецепты", false),
            Category(24, "Работа", false),
            Category(25, "Отдых", false),
            Category(26, "Спорт", false),
            Category(27, "Юмор", false),
            Category(28, "Еда", false),
            Category(29, "Кино", false),
            Category(30, "Рестораны", false),
            Category(31, "Прогулки", false),
            Category(32, "Политика", false),
            Category(33, "Новости", false),
            Category(34, "Автомобили", false),
            Category(35, "Сериалы", false),
            Category(36, "Рецепты", false),
            Category(37, "Работа", false),
            Category(38, "Отдых", false),
            Category(39, "Спорт", false),
        ), { _, _ -> }, {}, {})
    }
}