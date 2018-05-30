class CreateHomes < ActiveRecord::Migration[5.1]
  def change
    create_table :homes do |t|
      t.string :title
      t.text :description
      t.string :image_url
      t.text :contact_info

      t.timestamps
    end
  end
end
