class SayController < ApplicationController
  def hello
    @time = Time.now
  end

  def goodbye
    @files = Dir.glob('*')
    
    # <% @files.each do |file| %>
    #   file name is: <%= file %>
    # <% end %>
    
  end
end
