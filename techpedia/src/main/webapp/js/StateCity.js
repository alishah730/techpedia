function populate(state,city){
var state = document.getElementById(state);
var city = document.getElementById(city);
city.innerHTML = "";
if(state.value == "Andaman and Nicobar Islands"){
var arr = ["select city","Nicobar","North And Middle Andaman","South Andaman"];
}
if(state.value == "Andhra Pradesh"){
var arr = ["select city","Anantapur","Chittoor","Eluru","Guntur","Kadapa","Kakinada","Kurnool","Machilipatnam","Nellore","Ongole","Rajahmundry","Srikakulam","Vijayawada","Visakhapatnam","Vizianagaram"];
}
if(state.value == "Arunachal Pradesh"){
var arr =["select city","Changlang","Dibang Valley","East Kameng","East Siang","Kurung Kumey","Lohit","Lower Dibang Valley","Lower Subansiri","Papum Pare","Tawang","Tirap","Upper Siang","Upper Subansiri","West Kameng","West Siang"];
}
if(state.value == "Assam"){
var arr =["select city","Baksa","Barpeta","Cachar","Chirang","Darrang","Dhemaji","Dhubri","Dibrugarh","Goalpara","Golaghat","Guwahati","Hailakandi","Hamren","Jorhat","Karbi Anglong","Karimganj","Kokrajhar","Lakhimpur","Morigaon","Nagaon","Nalbari","North Chachar Hills","Sivasagar","Sonitpur","Tinsukia","Udalguri"];
}
if(state.value == "Bihar"){
var arr =["select city","Arrah","Aurangabad","Banka","Begusarai","Bhagalpur","Bhojpur","Buxar","Darbhanga","East Champaran","Gaya","Gopalganj","Jamui","Jehanabad","kaimur","Katihar","Khagaria","Kishanganj","Lakhisarai","madhepura","madhubani","Munger","Muzaffarpur","Nalanda","Nawada","Patna","Purnia","Rohtas","Saharsa","sheikhpura","Sheohar","Sitamarhi","Siwan","Supaul","Vaishali","West Champaran"];
}
if(state.value == "Chandigarh"){
var arr =["select city","Chandigarh"];
}
if(state.value == "Chhattisgarh"){
var arr =["select city","Balod","Baloda Bazar","Balrampur","Bastar","Bemetara","Bijapur","Bilaspur","Dantewada","Dhamtari","Durg","Gariaband","janjgir-Champa","Jashpur","Kabirdham","Kanker","Kondagaon","Korba","Korea","Mahasamund","Mungeli","Narayanpur","Raigarh","Raipur","Rajnandgaon","Sukma","Surajpur","Surguja"];
}
if(state.value == "Dadra and Nagar Haveli"){
var arr =["select city","Silvassa"];
}
if(state.value == "Daman and Diu"){
var arr =["select city","Daman","Diu"];
}
if(state.value == "National Capital Territory of Delhi"){
var arr =["select city","Delhi"];
}
if(state.value == "Goa"){
var arr =["select city","Goa"];
}
if(state.value == "Gujarat"){
var arr =["select city","Ahmedabad","Amreli","Anand","Aravalli","Banaskantha","Bharuch","Bhavnagar","Botad","Chhota Udepur","Dhaod","Devbhoomi Dwarka","Gir Somnath","Jamnagar","Junagadh","Kheda","Kutch","Mahisagar","Mehsana","Morbi","Narmada","Navsari","Panchmahal","Patan","Porbandar","Rajkot","Sabarkantha","Surat","Surendranagar","Tapi"];
}
if(state.value == "Haryana"){
var arr =["select city","Ambala","Bhiwani","Faridabad","Fatehabad","Gurgaon","Hisar","Jhajjar","Jind","Kaithal","Karnal","Kurukshetra","Mahendragarh","Mewat","Palwal","Panchkula","Panipat","Rewari","Rohtak","Sirsa","Sonipat","Yamunanagar"];
}
if(state.value == "Himachal Pradesh"){
var arr =["select city","Bilaspur","Chamba","Hamirpur","Kangra","Kinnaur","Kullu","Lahaul And Spiti","Mandi","Shimla","Sirmaur","Solan","UNA"];
}
if(state.value == "Jammu and Kashmir"){
var arr =["select city","Anantnag","Bandipore","Baramulla","Budgam","Doda","Ganderbal","Jammu","Kargil","Kathua","Kishtwar","Kulgam","Kupwara","Leh","Poonch","Pulwama","Rajouri","Ramban","Reasi","Samba","Shopian","Shrinagar","Udhampur"]
}
if(state.value == "Jharkhand"){
var arr =["select city","Bokaro","Deoghar","Dhanbad","Dumka","East Singbhum","Garhwa","Giridih","Gumla","Hazaribag","Pakur","Palamu","Ramgarh","Ranchi","Sahibganj","Seraikela","Simdega"];
}
if(state.value == "Karnataka"){
var arr =["select city","Bagalkot","Banguluru","Belgaum","Bellary","Bidar","Bijapur","Chamarajanagar","Chickmagalur","Chikballapur","Chitradurga","Dakshina Kannada","Davanagere","Dharwad","Gadag","Gulbarga","Hassan","Haveri","Kodagu","Kolar","Kolar Gold Fields","Koppal","Mandya","Mysore","Raichur","Ramnagara","Shimoga","Tumkur","Udupi","Uttara Kannada","Yadgir"];
}
if(state.value == "Kerala"){
var arr =["select city","Alappuzha","Cochin","Idukki","Kannur","Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"];
}
if(state.value == "Lakshadweep"){
var arr =["select city","Kavaratti"];
}
if(state.value == "Madhya Pradesh"){
var arr =["select city","Agar Malwa","Alirajpur","Anuppur","Ashoknagar","Balaghat","Barwani","Betul","Bhind","Bhopal","Burhanpur","Chhatarpur","Chhindwara","Damoh","Datia","Dewas","Dhar","Dindori","Guna","Gwalior","Harda","Hoshangabad","Indore","Jabalpur","Jhabua","Katni","Khandwa","Khargone","Mandla","Mandsaur","Morena","Narsinghpur","Neemuch","Panna","Raisen","Rajgarh","Ratlam","Rewa","Sagar","Satna","Sehore","Seoni","Shahdol","Shajapur","Sheopur","Shivpuri","Sidhi","Singrauli","Tikamgarh","Ujjain","Umaria","Vidisha"];
}
if(state.value == "Maharashtra"){
var arr =["select city","Ahmednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Bhuldhana","Chandrapur","Dhule","Gadchiroli","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai","Nagpur","Nanded","Nandurbar","Nashik","Navi Mumbai","Osmanabad","Parbhani","Pune","Raigad","Ratnagiru","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatal"];
}
if(state.value == "Manipur"){
var arr =["select city","Bishnupur","Chandel","Churachandpur","Imphal East","Imphal West","Senapati","Tamenglong","Thoubal","Ukhrul"];
}
if(state.value == "Meghalaya"){
var arr =["select city","East Khasi Hills","West Garo Hills"];
}
if(state.value == "Mizoram"){
var arr =["select city","Aizawl","Champhai","Kolasib","Lawngtlai","Lunglei","Mamit","Saiha","Serchhip"];
}
if(state.value == "Odisha"){
var arr =["select city","Angul","Balangir","Balasore","Bargarh","Berhampur","Bhadrak","Bhubaneshwar","Boudh","Cuttack","Deogarh","Dhenkanal","Gajapati","Ganjam","Jagatsinghapur","Jajpur","Jharsuguda","Kalahandi","Kandhamal","Kendrapara","Keonjhar","Khordha","Koraput","Malkangiri","Mayurbhanj","Nabarangapur","Nayagarh","Nuapada","Puri","Rayagada","Rourkela","Sambalpur","Sonepur","Sundargarh"];
}
if(state.value == "Puducherry"){
var arr =["select city","Karaikal","Mahe","Puducherry And Aureville","Yanam"];
}
if(state.value == "Punjab"){
var arr =["select city","Amritsar","Barnala","Batala","Bathinda","Faridkot","Fategarh Sahib","Fazilka","Ferozepur","Gurdaspur","Hoshiarpur","Jalandhar","Kapurthala","Khanna","Ludhiana","Mansa","Moga","Mohali","Nawanshahr","Pathankot","Patiala","Rupnagar","Sangrur","Shri Mukatsar Sahib","Tarn Taran"];
}
if(state.value == "Rajasthan"){
var arr =["select city","Ajmer","Alwar","Banswara","Baran","Barmer","Bnaratpur","Bhilwara","Bikaner","Bundi","Chittorgarh","Churu","Dausa","Dholpur","Dungarpur","Hanumangarh","Jaipur","Jaisalmer","Jalore","Jhalawar","Jhunjhunu","Jodhpur","Karauli","Kota","Nagaur","Pali","Pratapgarh","Rajsamand","Sawai Mahopur","Sokar","Sirohi","Sri Ganganagar","Tonk","Udaipur"];
}
if(state.value == "Sikkim"){
var arr =["select city","East Sikkim"];
}
if(state.value == "Tamil Nadu"){
var arr =["select city","Ariyalur","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul","Erode","Kanchipuram","Kanyakumari","Karur","Krishnagiri","Madurai","Nagapattinam","Namakkal","Nilgiris","Perambalur","Pudukkottai","Ramaathapuram","Salem","Sivaganga","Thanjavur","Theni","Thoothukudi","Tiruchirappalli","Tirunelveli","Tiruppur","Tiruvallur","Tiruvannamalai","Tiruvarur","Vellore","Villupuram","Virudhunagar"];
}
if(state.value == "Telangana"){
var arr =["select city","Adilabad","Hyderabad","Karimnagar","Khammam","Mahabubnagar","Medak","Nalgonda","Nizamabad","Rangareddy","Warangal"];
}
if(state.value == "Tripura"){
var arr =["select city","Dhalai","Gomati","Khowai","North Tripura","Sepahijala","South Tripura","Unakoti","West Tripura"];
}
if(state.value == "Uttarakhand"){
var arr =["select city","Almora","Bageshwar","Chamoli","Champawat","Dheradun","Haridwar","Nainital","Pauri Gharhwal","Pithoragarh","Rudraprayag","Tehri Garhwal","Udham singh Nagar","Uttarkashi"];
}
if(state.value == "Uttar Pradesh"){
var arr =["select city","Agra","Aligarh","Allahabad","Ambedkar nagar","Amethi","Auraiya","Azamgarh","Bagpat","Bahraich","Ballia","Balrampur","Banda","Barabanki","Bareilly","Basti","Bijnor","Budaun","Bulandshahr","Chandauli","Chitrakoot","Deoria","Etah","Etawah","Faizabad","Farrukhabad","Fatehpur","Firozabad","Gautam Buddha Nagar","Ghaziabad","Ghazipur","Gonda","Gorakhpur","Hamirpur","Hapur","Hardoi","Hathras","Jalaun","Jaunpur","Jhansi","Jyotiba Phule Nagar","Kannauj","Kanpur Dehat","Kanpur Nagar","Kasganj","Kaushambi","Kushinagar","Lakhimpur Kheri","Lalitpur","Lucknow","Maharajganj","Mahoba","Mainpuri","Mathura","Mau","Meerut","Mirzapur","Moradabad","Muzaffarnagar","Pilibhit","Pratapgarh","Raebareli","Rampur","Shaharanpur","Sambhal","Sant Kabir Nagar","Sant Ravidas Nagar","Shahajahanpur","Shamli","Shravasti","Siddharthnagar","Sitapur","Sonbhadra","Sultanpur","Unnao","Varanasi"];
}
if(state.value == "West Bengal"){
var arr =["select city","Aizawl","Champhai","Kolasib","Lawngtlai","Lunglei","Mamit","Saiha","Serchhip"];
}

for(var ar in arr){
var pair = arr[ar];
var nar = document.createElement("option");
nar.innerHTML = pair;
city.options.add(nar);
}
}