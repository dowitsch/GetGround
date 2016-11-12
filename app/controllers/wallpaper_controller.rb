class WallpaperController < ApplicationController
  APP_ID = '065d5257-2ce9-41bd-a423-9f7836592a74'

  def index
    path = "#{Rails.rooc}/public/images/image.jpg"
    send_file( path,
              disposition: 'inline',
              type: 'image/jpeg',
              x_sendfile: true )
  end

  def create
    wallpaper = params[:wallpaper]

    return if wallpaper.nil?
    File.open("#{Rails.root}/public/images/image.jpg",'wb') do |f|
      f.write wallpaper.first.read
    end
    send_notification
  end

  private

  def send_notification
    params = {
      "app_id" => APP_ID,
      "contents" => {"en" => "--"},
      "included_segments" => ["All"],
      "data" => {"img_uri" => "http://jbinder.teamserver.ch:3000/wallpaper"}
    }
    uri = URI.parse('https://onesignal.com/api/v1/notifications')
    http = Net::HTTP.new(uri.host, uri.port)
    http.use_ssl = true

    request = Net::HTTP::Post.new(uri.path,
                                  'Content-Type'  => 'application/json;charset=utf-8',
                                  'Authorization' => "Basic #{api_key}")
    request.body = params.as_json.to_json
    http.request(request)
  end


  def api_key
    @api_key ||= ENV['ONESIGNAL_API_KEY']
  end
end
