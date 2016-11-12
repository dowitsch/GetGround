(function($) {
  $(document).ready(function(){
    var pic = document.getElementById("pic").value
    var buttontext = document.getElementById("buttontext")
    var oldtext = document.getElementById("buttontext").innerHTML
    var text = "File uploading..."

    $('#pic').on('change', function() {
      buttontext.innerHTML=text
      document.getElementById('uploadform').submit();
      setTimeout(function(){ buttontext.innerHTML=oldtext }, 5000);
    });
  });
})(jQuery)
