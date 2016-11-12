class WallpaperController < ApplicationController

  def index
    path = "#{Rails.root}/public/images/image.jpg"
    send_file( path,
      disposition: 'inline',
      type: 'image/jpeg',
      x_sendfile: true )
  end

  def create
    wallpaper = params[:wallpaper].first

    File.open("#{Rails.root}/public/images/image.jpg",'wb') do |f|
      f.write wallpaper.read
    end
  end

  private

  def uploader
    @uploader ||= ImageUploader.new
  end
end
