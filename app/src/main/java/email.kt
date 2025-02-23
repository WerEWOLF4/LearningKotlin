package email //Pachetul trebuie numaidecat introdus sus

import android.provider.ContactsContract.CommonDataKinds.Email
import  email. * //import la tot pachetul
//Tipuri din pachete
import email.send
import email.Message

// Import ca tip
import email.send as sendEmail
import email.Message as EmailMessage

import sms.send as sendSms
import sms.Message as SmsMessage

class Message(val text: String)

fun send(message: Message, address: String){
    println("Message `${message.text}` has been sent to $address")
}

fun main () {

    val myMessage = EmailMessage("Hello Kotlin")
    sendEmail(myMessage, "tom@gmail.com")

    val mySmsMessage = SmsMessage("Hello Kotlin")
    sendSms(mySmsMessage, "+1234567890")


}




