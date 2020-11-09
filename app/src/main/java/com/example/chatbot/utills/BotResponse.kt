package com.example.chatbot.utills

import com.example.chatbot.utills.Constants.OPEN_GOOGLE
import com.example.chatbot.utills.Constants.OPEN_SEARCH
import java.lang.Exception

object BotResponse {

    fun basicReponses(_message: String): String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{
            //인사
            message.contains("안녕") -> {
                when (random){
                    0 -> "안녕"
                    1 -> "반가워"
                    else -> "나도"
                }
                
            }
            //오늘 어때?
            message.contains("오늘 어때?") -> {
                when (random) {
                    0 -> "기분 좋아! 너도 기분 좋은 하루지? "
                    1 -> "너무 힘들어 하지만 너가 기분을 물어봐줘서 기분이 좋아질거 같아"
                    3 -> "괜찮아! 너는 어때?"
                    else -> "피곤해"

                }
            }
            //coin
            message.contains("동전") ->{
                var r = (0..1).random()
                val result = if (r==0) "앞면" else "뒷면"

                "동전 뒤집기 결과는 $result"
            }
            //solve
            message.contains("풀어줘") ->{
                val equation: String? = message.substringAfter("풀어줘")

                return try{
                    val answer = SolveMate.solveMath(equation ?: "0")
                    answer.toString()
                }catch (e: Exception){
                    "그건 내가 못 푸는 문제야"
                }
            }
            //Time
            message.contains("몇 시?") && message.contains("?") ->{
                Time.timeStamp()
            }


            else ->{
                when (random){
                    0 -> "다른 질문 해줘"
                    1 -> "그런건 아직 잘 몰라"
                    3 -> "모르겠어"
                    else -> "error"
                }
            }

            }
        }
}