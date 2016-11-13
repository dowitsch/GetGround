Rails.application.routes.draw do
  root 'homes#index'
  resources :wallpaper, only: [:index, :create]
  post 'upload' => 'wallpaper#create2'
end
