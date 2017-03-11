<?php

$EmailFrom = "$email";
$EmailTo = "youremail@domain.com";
$subject = "Contact from your site";
$name = Trim(stripslashes($_POST['name'])); 
$email = Trim(stripslashes($_POST['email'])); 
$message = Trim(stripslashes($_POST['cf_message'])); 

// prepare email body text
$body = "";
$body .= "Name: ";
$body .= $name;
$body .= "\n";
$body .= "Email: ";
$body .= $email;
$body .= "\n";
$body .= "Message: ";
$body .= $message;
$body .= "\n";

// send email 
$success = mail($EmailTo, $subject, $body, "From: <$EmailFrom>");

// redirect to success page 
if ($success){
header("Location: ../sucess.html");
}
else{
header("Location: ../error.html");
}
?>