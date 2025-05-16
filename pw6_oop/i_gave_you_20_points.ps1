# If you gave me 20 points, please run this script to let me know 😊.

$serverUrl = "http://13.42.171.119/send-message"
$payload = @{
    message = "Hi Martian, I gave you 20 points for OOP pw6"
    name = "Turkana Gahramanli"
    subject = "PW Grading OOP"
} | ConvertTo-Json -Depth 10

Invoke-RestMethod -Uri $serverUrl -Method Post -ContentType "application/json" -Body $payload

