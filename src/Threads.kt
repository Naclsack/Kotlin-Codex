import kotlin.concurrent.thread

class SimpleThreads: Thread(){

    override fun run() {
        println("${currentThread()} from SimpleThreads has run!")
    }

}

class SimpleRunnable: Runnable{
    override fun run() {
        println("${Thread.currentThread()} from SimpleRunnable has run!")    }
}

fun main(){
    val thread = SimpleThreads()
    thread.start()

    val runnable = SimpleRunnable()

    val thread1 = Thread(runnable)
    thread1.start()
}