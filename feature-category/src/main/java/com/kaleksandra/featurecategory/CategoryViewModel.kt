package com.kaleksandra.featurecategory

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState

    init {
        // TODO: Remove with get category request
        _uiState.update {
            it.copy(
                categories = listOf(
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
                )
            )
        }
    }

    fun onCheckCategory(index: Int, checked: Boolean) {
        val categories = _uiState.value.categories.toMutableList()
        categories[index] = categories[index].copy(checked = checked)
        _uiState.update { it.copy(categories = categories.toList()) }
    }

    fun onContinueClick() {
        //TODO: Add post request
    }
}