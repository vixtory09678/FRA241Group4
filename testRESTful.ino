#include <ESP8266WiFi.h>

int test_delay = 1000; //so we don't spam the API
boolean describe_tests = true;

const char* ssidWiFi = "teamkuywa";
const char* passWiFi = "testtest";
//for connect wifi

const char* host = "api.thingspeak.com";
const int PORT = 80;
const char* contentType = "application/x-www-form-urlencoded";
const char* url = "/channels/106748/fields/1/last.json";

const char* API_KEY = "CQ0CIKNV5SONBQS3";
const char* channel_id = "106748";
//RestClient client  = RestClient("10.0.1.47",5000);

WiFiServer server(80);

//Setup
void setup() {
  Serial.begin(115200);

  WiFi.begin(ssidWiFi,passWiFi);
  while(WiFi.status() != WL_CONNECTED){
    Serial.print(".");
    delay(500);
  }
  Serial.println("\n\n");
  Serial.print("connected : ");
  Serial.println(WiFi.localIP());

  Serial.println("Setup!");
}

String line = "";
// Run the tests!
void loop(){
  delay(500);
  WiFiClient client = server.available(); 
  Serial.print("Requesting URL : ");
  Serial.println(url);
  
  if(!client.connect(host,PORT)){
    Serial.print(".");
    return;
  }else{
    client.print(String("GET ")+url+" HTTP/1.1\r\n" +
                        "Host: " + host +"\r\n" +
                        "Connection: close\r\n"+
                        "Content-Type: "+contentType+"\r\n\r\n");
                      delay(50);
    Serial.println("SEND !!");
  }
  while(!client.available()){
  }
  while(client.available()){
    line += (char)client.read();
  }
  String json = "";
  if(line.indexOf("{")<0){
    json = "empty";
  }else{
    json = line.substring(line.indexOf("{"),line.indexOf("}")+1);
  }
  
  Serial.println(json);
  client.stop();
  line = "";
}