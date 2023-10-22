package me.dio.copa.catar.notification.scheduler.extensions

import android.content.Context
import androidx.work.*
import me.dio.copa.catar.domain.model.MatchDomain
import java.time.Duration
import java.time.LocalDateTime

private const val NOTIFICATION_TITLE_KEY = "NOTIFICATION_TITLE_KEY"
private const val NOTIFICATION_CONTENT_KEY = "NOTIFICATION_CONTENT_KEY"

class NotificationMatcherWorker(
    private val context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        val title = inputData.getString(NOTIFICATION_TITLE_KEY)
            ?: throw java.lang.IllegalArgumentException("Required title")
        val content = inputData.getString(NOTIFICATION_CONTENT_KEY)
            ?: throw java.lang.IllegalArgumentException("Required content")

        context.showNotification(title, content)

        return Result.success()
    }

    companion object {
        fun onStart(context: Context, matchDomain: MatchDomain) {
            val (id, _, _, team1, team2, matchDate) = matchDomain
            val initialDelay = Duration.between(LocalDateTime.now(), matchDate).minusMinutes(5)
            val inputData = workDataOf(
                NOTIFICATION_TITLE_KEY to "Se prepare que o jogo vai começar",
                NOTIFICATION_CONTENT_KEY to "Hoje tem ${team1.flag} vs ${team2.flag}",
            )

            WorkManager.getInstance(context)
                .enqueueUniqueWork(
                    matchDomain.id,
                    ExistingWorkPolicy.KEEP,
                    createRequest(initialDelay, inputData)
                )
        }

        private fun createRequest(initialDelay: Duration, inputData: Data) : OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<NotificationMatcherWorker>()
                .setInitialDelay(initialDelay)
                .setInputData(inputData)
                .build()
        }


        fun onCancel(context: Context, matchDomain: MatchDomain) {
            WorkManager.getInstance(context)
                .cancelUniqueWork(matchDomain.id)
        }
    }


}