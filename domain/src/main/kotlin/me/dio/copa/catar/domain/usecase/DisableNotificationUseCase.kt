package me.dio.copa.catar.domain.usecase

import me.dio.copa.catar.domain.repositories.MatchesRepository
import javax.inject.Inject

class DisableNotificationUseCase @Inject constructor(
    private val repository: MatchesRepository
) {
    suspend fun invoke(id: String) : Unit = repository.disableNotificationFor(id)
}